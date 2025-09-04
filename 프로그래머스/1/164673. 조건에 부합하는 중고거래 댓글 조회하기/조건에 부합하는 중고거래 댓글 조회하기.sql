# -- 코드를 입력하세요
SELECT ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, date_format(ugr.created_date, "%Y-%m-%d")
    from used_goods_board ugb
    join used_goods_reply ugr
      on ugb.board_id = ugr.board_id
      # and ugr.created_date >= "2022-10-01"
      # and ugr.created_date < "2022-11-01"
    where ugb.created_date >= "2022-10-01"
      and ugb.created_date < "2022-11-01"
    order by ugr.created_date, ugb.title;