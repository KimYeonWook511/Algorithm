select min(case
            when (d.skill_code & (select code from skillcodes where name = 'Python')) > 0 and s.category = 'Front End' then 'A'
            when (d.skill_code & (select code from skillcodes where name = 'C#')) then 'B'
            when (s.category = 'Front End') then 'C'
        end) as GRADE, id, email
  from developers as d
  join skillcodes as s
    on (d.skill_code & s.code) > 0
  group by id, email having GRADE is not null
  order by GRADE, id;