select d.dept_id, d.dept_name_en, round(avg(sal), 0) as avg_sal
  from hr_department as d
  join hr_employees as e
    on d.dept_id = e.dept_id
  group by d.dept_id, d.dept_name_en
  order by avg_sal desc;