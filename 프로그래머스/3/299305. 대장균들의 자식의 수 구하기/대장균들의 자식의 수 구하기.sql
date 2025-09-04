-- 코드를 작성해주세요

# select ed.id, ifnull(sub.child_count, 0) as child_count
#   from ecoli_data ed
#   left join (select parent_id, count(*) as child_count
#                 from ecoli_data
#                 group by parent_id) as sub
#     on ed.id = sub.parent_id
#   order by ed.id;

select ed.id, count(sub.id) as child_count
  from ecoli_data ed
  left join ecoli_data as sub
    on ed.id = sub.parent_id
  group by ed.id
  order by ed.id;