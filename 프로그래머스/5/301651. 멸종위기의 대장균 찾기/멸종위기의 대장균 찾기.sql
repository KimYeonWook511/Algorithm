# with recursive temp as (
#     select id, 1 as GENERATION
#       from ecoli_data
#       where parent_id is null
    
#     union all
    
#     select ed.id, t.GENERATION + 1
#       from ecoli_data as ed
#       join temp as t
#         on ed.parent_id = t.id
# )

# select * from temp;

with recursive temp_1 as (
    select id, parent_id, 1 as GENERATION
      from ecoli_data
      where parent_id is null
    
    union all
    
    select ed.id, ed.parent_id, t.GENERATION + 1
      from ecoli_data as ed
      join temp_1 as t
        on ed.parent_id = t.id
)

select count(*) as COUNT, GENERATION
  from temp_1 as t
  left join ecoli_data as ed
    on t.id = ed.parent_id
  where ed.id is null
  group by GENERATION
  order by GENERATION;