select id as ID, fish_name as FISH_NAME, length as LENGTH
  from fish_info as fi
  join fish_name_info as fni
    on fi.fish_type = fni.fish_type
  where (fi.fish_type, length) in (select fish_type, max(length)
                                  from fish_info
                                  group by fish_type)
  order by id;