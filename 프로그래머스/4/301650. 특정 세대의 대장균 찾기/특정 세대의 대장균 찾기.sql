select e3.id
  from ecoli_data as e3
  join ecoli_data as e2
    on e3.parent_id = e2.id
  join ecoli_data as e1
    on e2.parent_id = e1.id
    and e1.parent_id is null
  order by id;