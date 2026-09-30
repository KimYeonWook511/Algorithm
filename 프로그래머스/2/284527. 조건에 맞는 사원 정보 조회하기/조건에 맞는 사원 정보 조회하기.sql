select sum(score) as SCORE, e.emp_no, emp_name, position, email
  from hr_grade as g
  join hr_employees as e
    on g.emp_no = e.emp_no
  where year = 2022
  group by e.emp_no
  order by SCORE desc
  limit 1;