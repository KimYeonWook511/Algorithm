select id, email, first_name, last_name
  from developers as d
  where exists (select 1
                from skillcodes as s
                where d.skill_code & s.code
                  and s.category = 'Front End')
  order by id;