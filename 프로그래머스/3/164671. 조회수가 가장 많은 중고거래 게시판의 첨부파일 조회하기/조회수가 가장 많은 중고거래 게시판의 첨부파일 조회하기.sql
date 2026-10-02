with board_rank as (
    select board_id, rank() over(order by views desc) as rnk
      from used_goods_board
)

select concat("/home/grep/src/", f.board_id, "/", file_id, file_name,file_ext) as FILE_PATH
  from used_goods_file as f
  join board_rank as br
    on f.board_id = br.board_id
  where br.rnk = 1
  order by file_id desc;