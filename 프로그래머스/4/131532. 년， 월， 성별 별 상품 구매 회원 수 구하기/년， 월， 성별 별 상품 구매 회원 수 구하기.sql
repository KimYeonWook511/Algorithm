select year(sales_date) as year, month(sales_date)as month, gender, count(distinct ui.user_id) as users
  from user_info as ui
  join online_sale as os
    on ui.user_id = os.user_id
  where gender is not null
  group by year(sales_date), month(sales_date), gender
  order by 1, 2, 3;