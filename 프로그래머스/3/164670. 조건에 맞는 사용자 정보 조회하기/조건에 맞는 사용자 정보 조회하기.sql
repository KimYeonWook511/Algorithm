select user_id, nickname, concat(city, " ", street_address1, " ", street_address2) as 전체주소, concat(left(tlno, 3), "-", substr(tlno, 4, 4), "-", right(tlno, 4)) as 전화번호
  from used_goods_user as u
  where exists (select 1
                from used_goods_board
                where u.user_id = writer_id
                group by writer_id having count(*) >= 3)
  order by user_id desc;