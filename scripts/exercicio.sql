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
select cidade.nome nome_cidade, count(c) from cidade inner join candidato c on c.cidade = cidade.id 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' group by cidade.nome order by cidade.nome;

--15
select vi.nulos, vi.brancos, cargo.nome from voto_invalido vi inner join cargo on cargo.id = vi.cargo 
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--16
select sum(vi.brancos + vi.nulos) from voto_invalido vi inner join cargo c on c.id = vi.cargo and c.nome = 'Prefeito'
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--17
select voto.voto as votos, c.nome from voto inner join candidato c on voto.candidato = c.id inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO' order by votos desc;
--18
select voto.voto as votos, c.nome from voto inner join candidato c on voto.candidato = c.id inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO' order by votos desc;

--19
select cidade.nome, max(voto.voto) 
from cidade 
inner join candidato c on c.cidade = cidade.id 
inner join voto on voto.candidato = c.id
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

--20
select partido.sigla, sum(voto.voto) as voto
from partido 
inner join candidato on candidato.partido  = partido.id 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id 
group by partido.sigla order by voto desc;

--21
select sum(voto.voto + vi.brancos + vi.nulos) from voto 
inner join candidato c on c.id = voto.candidato 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO'
inner join voto_invalido vi on vi.cidade = cidade.id
group by cargo.nome;

--22 incompleto
select cidade.qt_eleitores - (sum(voto.voto + vi.brancos + vi.nulos) - cidade.qt_vereadores) from cidade
inner join voto_invalido vi on vi.cidade = cidade.id 
inner join candidato c on c.cidade = cidade.id 
inner join voto on voto.candidato = c.id
where cidade.nome = 'TUBARÃO'
group by ;

