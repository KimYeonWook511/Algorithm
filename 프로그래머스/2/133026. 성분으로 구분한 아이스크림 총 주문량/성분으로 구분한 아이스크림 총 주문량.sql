select ingredient_type, sum(total_order) as TOTAL_ORDER
  from first_half as fh
  join icecream_info as ii
    on fh.flavor = ii.flavor
  group by ingredient_type
  order by TOTAL_ORDER;