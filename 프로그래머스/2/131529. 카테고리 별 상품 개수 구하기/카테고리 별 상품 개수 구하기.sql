select left(product_code, 2) as category, count(*) as products
  from product
  group by left(product_code, 2)
  order by `category`;