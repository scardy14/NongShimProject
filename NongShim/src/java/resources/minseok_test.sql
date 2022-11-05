select * from  NongShim_product_Post;

select * from NongShim_productPostComments 

select title,content, hits,nickname,comments,register_date,category,product_name,product_point,duration,min_customer,max_customer from NongShim_product_Post where post_no=2;


update NONGSHIM_PRODUCTPOSTCOMMENTS set content = '바뀐 내용 입니다.' where id='java' and post_no=2 and comments_date=?;




select row_number() over(order by comments_date) as rnum,content,category,id,comments_date 
from NongShim_productPostComments where post_no=1 and id='spring' ;