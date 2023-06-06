--1
select * from cargo c;

--2
select nome, qt_vereadores from cidade order by nome;

--3
select nome, qt_vereadores from cidade where qt_vereadores > 9;

--4
select count(nome) from cidade c where qt_vereadores > 9; 

--5
select max(qt_vereadores) from cidade;

--6
select nome from cidade where qt_vereadores = (select max(qt_vereadores) from cidade);

--7
select c.nome, cargo.nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' order by nome;

--8
select nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' where c.nome like '%MARIA %' order by c.nome;

--9
select c.nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' where c.nome like 'Y%' order by nome;

--10
select c.nome, cidade.nome from candidato c inner join cidade on cidade.id = c.cidade order by cidade.nome, c.nome;

--11
select c.nome candidatos_prefeito from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' 
inner join cidade on cidade.id = c.cidade  and cidade.nome = 'TUBARÃO' order by c.nome;

--12
select c.nome candidatos_prefeito from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' 
inner join cidade on cidade.id = c.cidade where cidade.qt_eleitores = (select max(qt_eleitores) from cidade); 

--13
select count(cidade.qt_vereadores) from cidade inner join candidato c on c.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador';

--14
select cidade.nome nome_cidade, cidade.qt_vereadores from cidade inner join candidato c on c.cidade = cidade.id 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' order by cidade.nome;

--15
select vi.nulos, vi.brancos, cargo.nome from voto_invalido vi inner join cargo on cargo.id = vi.cargo 
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--16
select sum(vi.brancos + vi.nulos) from voto_invalido vi inner join cargo c on c.id = vi.cargo and c.nome = 'Prefeito'
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--17
select voto.voto from voto inner join 