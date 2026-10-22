select count(*) as fish_count, max(if(length is null, 10, length)) as amx_length, fish_type
  from fish_info
  group by fish_type having avg(if(length is null, 10, length)) >= 33
  order by fish_type;