-- 코드를 작성해주세요
select count(*) as fish_count
  from fish_info fi
  inner join fish_name_info fni
    on fi.fish_type = fni.fish_type
    and fni.fish_name in ('BASS', 'SNAPPER');