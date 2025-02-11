select p.PRODUCT_CODE ,  sum(p.price *o.SALES_AMOUNT) as SALES
from product as p 
inner join offline_sale as o on p.product_id = o.product_id
group by product_code
order by SALES desc , p.product_code