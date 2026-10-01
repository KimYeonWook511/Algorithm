select h.flavor
  from first_half as h
  join july as j
    on h.flavor = j.flavor
  group by h.flavor
  order by h.total_order + sum(j.total_order) desc
  limit 3;