select ed3.id
  from ecoli_data as ed3
  join ecoli_data as ed2
    on ed3.parent_id = ed2.id
  join ecoli_data as ed1
    on ed2.parent_id = ed1.id
  where ed1.parent_id is null
  order by id;