# -- 코드를 입력하세요
select fh.flavor
  from first_half fh
  join icecream_info ii
    on fh.flavor = ii.flavor
    and ii.ingredient_type = "fruit_based"
  where fh.total_order > 3000
  order by fh.total_order desc;