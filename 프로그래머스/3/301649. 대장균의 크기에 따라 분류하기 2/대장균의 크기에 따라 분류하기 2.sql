with tmp as (
    select id, rank() over(order by size_of_colony desc) as rnk
      from ecoli_data
)

select id, 
        case
            when rnk <= ((select count(*) from ecoli_data) * 1 / 4) then "CRITICAL"
            when rnk <= ((select count(*) from ecoli_data) * 2 / 4) then "HIGH"
            when rnk <= ((select count(*) from ecoli_data) * 3 / 4) then "MEDIUM"
            when rnk <= ((select count(*) from ecoli_data) * 4 / 4) then "LOW"
        end as colony_name
  from tmp
  order by id;