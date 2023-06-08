--1 Selecionar todos os registros e atributos da entidade cargo.
select * from cargo c;

--2 Selecionar e a quantidade de vereadores da entidade cidade, ordenado pelo nome da cidade.
select nome, qt_vereadores from cidade order by nome;

--3 Selecionar e a quantidade de vereadores da entidade cidade, somente das cidades 
--que possuem mais de 9 vereadores.
select nome, qt_vereadores from cidade where qt_vereadores > 9;

--4. Selecionar quantas cidades possuem mais de 9 vereadores.
select count(nome) from cidade c where qt_vereadores > 9; 

--5. Selecionar a quantidade máxima de vereadores que uma cidade possui.
select max(qt_vereadores) from cidade;

--6. Selecionar o nome da cidade que possui mais vereadores.
select nome from cidade where qt_vereadores = (select max(qt_vereadores) from cidade);

--7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome.
select c.nome, cargo.nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' order by nome;

--8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome ordenados pelo nome.
select nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' where c.nome like '%MARIA %' order by c.nome;

--9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select c.nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' where c.nome like 'Y%' order by nome;

--10. Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da 
--cidade e em seguida pelo nome do candidato.
select c.nome, cidade.nome from candidato c inner join cidade on cidade.id = c.cidade order by cidade.nome, c.nome;

--11. Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO', ordenado pelo nome do candidato.
select c.nome candidatos_prefeito from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' 
inner join cidade on cidade.id = c.cidade  and cidade.nome = 'TUBARÃO' order by c.nome;

--12. Selecionar o nome dos candidatos a prefeito da cidade que tem o maior número de eleitores.
select c.nome candidatos_prefeito from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' 
inner join cidade on cidade.id = c.cidade where cidade.qt_eleitores = (select max(qt_eleitores) from cidade); 

--13. Selecionar a quantidade de candidatos a vereador da cidade de 'TUBARÃO'.
select count(cidade.qt_vereadores) from cidade inner join candidato c on c.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador';

--14. Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade.
select cidade.nome nome_cidade, count(c) from cidade inner join candidato c on c.cidade = cidade.id 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' group by cidade.nome order by cidade.nome;

--15. Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da 
--cidade de Tubarão.
select vi.nulos, vi.brancos, cargo.nome from voto_invalido vi inner join cargo on cargo.id = vi.cargo 
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--16. Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para 
--prefeito da cidade de Tubarão
select sum(vi.brancos + vi.nulos) from voto_invalido vi inner join cargo c on c.id = vi.cargo and c.nome = 'Prefeito'
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--17. Selecionar a quantidade de votos válidos para cada candidato a prefeito da cidade de 
--Tubarão, ordenados pela maior quantidade de votos
select voto.voto as votos, c.nome from voto inner join candidato c on voto.candidato = c.id inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO' order by votos desc;
--18. Selecionar a quantidade de votos válidos para CADA candidato a vereador da 
--cidade de Tubarão ordenados pela maior quantidade de votos.
select voto.voto as votos, c.nome from voto inner join candidato c on voto.candidato = c.id inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO' order by votos desc;

--19. Selecionar a maior quantidade de votos para prefeito de cada cidade.
select cidade.nome, max(voto.voto) 
from cidade 
inner join candidato c on c.cidade = cidade.id 
inner join voto on voto.candidato = c.id
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

--20. Selecionar os partidos e a quantidade de votos de cada um na cidade de Tubarão 
--ordenados pela maior quantidade de votos.
select partido.sigla, sum(voto.voto) as voto
from partido 
inner join candidato on candidato.partido  = partido.id 
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id 
group by partido.sigla order by voto desc;

--21. Selecionar a quantidade de votos registrados para prefeito na cidade de tubarão. Os 
--votos registrados são considerados os votos para os candidatos, mais os votos brancos e nulos.
select sum(voto.voto + vi.brancos + vi.nulos) from voto 
inner join candidato c on c.id = voto.candidato 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = c.cidade and cidade.nome = 'TUBARÃO'
inner join voto_invalido vi on vi.cidade = cidade.id
group by cargo.nome;

--22. Selecionar a quantidade de eleitores que deixaram de votar na cidade de tubarão.   
select cidade.qt_eleitores - (sum(voto.voto) + voto_invalido.brancos + voto_invalido.nulos) from cidade
inner join candidato on candidato.cidade = cidade.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join voto on voto.candidato = candidato.id
inner join voto_invalido on voto_invalido.cidade = cidade.id and voto_invalido.cargo = cargo.id
where cidade.nome = 'TUBARÃO'
group by cidade.qt_eleitores,voto_invalido.brancos, voto_invalido.nulos;

--23. Selecionar a quantidade de eleitores que deixaram de votar em cada cidade, ordenado pela maior quantidade de faltantes.
select cidade.nome, (cidade.qt_eleitores - ((sum(voto.voto)) + vi.brancos + vi.nulos)) as faltantes from cidade
inner join candidato c on c.cidade = cidade.id 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
inner join voto on voto.candidato = c.id
inner join voto_invalido vi on vi.cargo = cargo.id and vi.cidade = cidade.id
group by cidade.nome, cidade.qt_eleitores,vi.brancos, vi.nulos
order by faltantes desc;

--24. Selecionar o percentual de faltantes em cada cidade, ordenado pelo maior percentual.
select cidade.nome, round(((cidade.qt_eleitores - ((sum(voto.voto)) + voto_invalido.brancos + voto_invalido.nulos)) 
/ cidade.qt_eleitores * 100),2) as percentual from cidade
inner join candidato on candidato.cidade = cidade.id 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join voto on voto.candidato = candidato.id 
inner join voto_invalido on voto_invalido.cargo = cargo.id and voto_invalido.cidade = cidade.id
group by cidade.nome, cidade.qt_eleitores, voto_invalido.brancos, voto_invalido.nulos
order by percentual desc;

-- 25 Selecionar o candidato a prefeito eleito de cada cidade, ordenado pelo nome da cidade
select distinct on (cidade.nome) cidade.nome, candidato.nome, (max(voto.voto)) from candidato
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join voto on voto.candidato = candidato.id 
inner join cidade on cidade.id = candidato.cidade
group by cidade.nome, candidato.nome, voto.voto
order by cidade.nome, voto.voto desc;

