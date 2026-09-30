select user_id, nickname, sum(price) as TOTAL_SALES
  from used_goods_user as u
  join used_goods_board as b
    on u.user_id = b.writer_id
  where status = 'DONE'
  group by user_id, nickname having sum(price) >= 700000
  order by TOTAL_SALES;