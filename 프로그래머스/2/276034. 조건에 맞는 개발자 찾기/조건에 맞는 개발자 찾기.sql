-- 코드를 작성해주세요
select dev.id, dev.email, dev.first_name, dev.last_name
  from developers dev
  where exists (select 1
                  from skillcodes sc
                  where (dev.skill_code & sc.code) > 0
                    and sc.name in ('Python', 'C#'))
  order by dev.id;