SELECT A.BOOK_ID, B.AUTHOR_NAME, DATE_FORMAT(A.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
FROM BOOK A LEFT JOIN AUTHOR B ON A.AUTHOR_ID = B.AUTHOR_ID
WHERE CATEGORY in ('경제')
ORDER BY PUBLISHED_DATE