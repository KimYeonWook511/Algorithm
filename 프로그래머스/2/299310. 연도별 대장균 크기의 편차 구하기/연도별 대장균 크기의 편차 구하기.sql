with tmp as (
    select year(differentiation_date) as year, max(size_of_colony) as max_size
      from ecoli_data
      group by year
)


select year, (max_size - size_of_colony) as year_dev, id
  from ecoli_data as ed
  join tmp
    on year(ed.differentiation_date) = tmp.year
  order by year, year_dev;