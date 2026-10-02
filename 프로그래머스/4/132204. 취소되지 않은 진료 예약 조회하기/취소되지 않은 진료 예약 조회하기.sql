select a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_name, apnt_ymd
  from appointment as a
  join patient as p
    on a.pt_no = p.pt_no
  join doctor as d
    on a.mddr_id = d.dr_id
  where date(apnt_ymd) = '2022-04-13'
    and apnt_cncl_yn = 'N'
    and a.mcdp_cd = 'CS'
  order by apnt_ymd;
    