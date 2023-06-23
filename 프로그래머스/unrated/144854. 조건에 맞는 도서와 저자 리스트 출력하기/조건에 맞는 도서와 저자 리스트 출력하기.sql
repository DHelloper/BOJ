# select A.BOOK_ID, B.AUTHOR_NAME, DATE_FORMAT(A.PUBLISHED_DATE,"%Y-%d-%m") as PUBLISHED_DATE
# FROM BOOK A JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
# WHERE CATEGORY = '경제'
# ORDER BY PUBLISHED_DATE

# select * 
# from BOOK A join author B on a.author_id = b.author_id

SELECT a.BOOK_ID, b.AUTHOR_NAME,
date_format(a.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from book a join author b on a.author_id = b.author_id
where category in ('경제')
order by PUBLISHED_DATE