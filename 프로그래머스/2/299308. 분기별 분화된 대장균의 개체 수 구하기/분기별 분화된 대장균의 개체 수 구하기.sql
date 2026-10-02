select concat(floor((month(differentiation_date) + 2) / 3), "Q") as quarter, count(*) as ecoli_count
  from ecoli_data
  group by floor((month(differentiation_date) + 2) / 3)
  order by quarter;
  