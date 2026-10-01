select order_id, product_id, out_date, if(out_date <= "2022-05-01", "출고완료", if(out_date is not null, "출고대기", "출고미정")) as 출고여부
  from food_order
  order by order_id;