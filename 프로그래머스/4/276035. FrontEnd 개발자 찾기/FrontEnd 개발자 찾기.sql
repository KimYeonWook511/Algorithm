select id, email, first_name, last_name
  from developers as d
  where exists (select 1 
                from skillcodes 
                where category = "Front End"
                  and (d.skill_code & code) > 0)
  order by id;