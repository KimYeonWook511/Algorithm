select min(GRADE) as GRADE, id, email
  from (select case
                 when (d.skill_code & (select code from skillcodes where name = 'Python')) > 0 and s.category = 'Front End' then 'A'
                 when (d.skill_code & (select code from skillcodes where name = 'C#')) then 'B'
                 when (s.category = 'Front End') then 'C'
               end as GRADE, id, email
          from developers as d
          join skillcodes as s
            on (d.skill_code & s.code) > 0) as sub
  where GRADE is not null
  group by id, email
  order by GRADE, id;