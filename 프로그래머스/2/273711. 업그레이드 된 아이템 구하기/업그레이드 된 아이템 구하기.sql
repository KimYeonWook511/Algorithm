-- 코드를 작성해주세요
# select item_id, item_name, rarity
#   from item_info
#   where item_id in (select item_id
#                       from item_tree
#                       where parent_item_id in (select item_id 
#                                                  from item_info 
#                                                  where rarity = 'RARE'))
#   order by item_id desc;

# 아래 쿼리가 더 효율적으로 보임
select item_id, item_name, rarity
  from item_info ii
  where exists (select 1
                  from item_info i
                  inner join item_tree t
                    on i.item_id = t.parent_item_id
                    and i.rarity = 'RARE'
                  where ii.item_id = t.item_id)
  order by item_id desc;
  