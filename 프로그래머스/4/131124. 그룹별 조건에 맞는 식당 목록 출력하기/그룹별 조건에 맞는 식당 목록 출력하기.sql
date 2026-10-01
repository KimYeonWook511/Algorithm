with review_rank as (
    select member_id, rank() over (order by count(*) desc) as rnk
      from rest_review
     group by member_id
)

select member_name, review_text, review_date
  from member_profile as m
  join rest_review as r
    on m.member_id = r.member_id
  join review_rank as rr
    on m.member_id = rr.member_id
  where rnk = 1
  order by review_date, review_text;