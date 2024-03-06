-- 코드를 입력하세요
select a.flavor
from (select flavor, sum(total_order) as at
        from first_half
        group by flavor) as a
left join (select flavor, sum(total_order) as bt
             from july
             group by flavor) as b
on a.flavor = b.flavor
order by (at + bt) desc
limit 3;