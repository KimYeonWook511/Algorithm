select p.product_id, product_name, (price * sum(amount)) as total_sales
  from food_product as p
  join food_order as o
    on p.product_id = o.product_id
  where date_format(produce_date, "%Y-%m") = "2022-05"
  group by p.product_id
  order by `total_sales` desc, p.product_id;