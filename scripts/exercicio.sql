select * from cargo c;

select nome, qt_vereadores from cidade order by nome;

select nome, qt_vereadores from cidade where qt_vereadores > 9;

select count(nome) from cidade c where qt_vereadores > 9; 
