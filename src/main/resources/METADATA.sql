USE [SPRINGBOOT_DEMO]

INSERT INTO [dbo].[ADDRESS]
           ([ADDRESS_LINE1]
           ,[ADDRESS_LINE2]
           ,[CITY]
           ,[STATE]
           ,[COUNTRY]
           ,[ZIP_CODE]
           ,[CREATED_BY]
           ,[CREATED_ON]
           ,[MODIFIED_BY]
           ,[MODIFIED_ON])
     VALUES
           ('Addr Line 1'
           ,'Addr Line 2'
           ,'City 1'
           ,'State 1'
           ,'India'
           ,123456
           ,-1
           ,GETDATE()
           ,-1
           ,GETDATE())
GO

INSERT INTO [dbo].[DEPARTMENT]
           ([DEPARTMENT_NAME]
           ,[CREATED_BY]
           ,[CREATED_ON]
           ,[MODIFIED_BY]
           ,[MODIFIED_ON])
     VALUES
           ('Department 1'
           ,-1
           ,GETDATE()
           ,-1
           ,GETDATE())
GO




INSERT INTO [dbo].[EMPLOYEE]
           ([EMPLOYEE_NAME]
           ,[AGE]
           ,[SALARY]
           ,[DEPARTMENT_ID]
           ,[ADDRESS_ID]
           ,[CREATED_BY]
           ,[CREATED_ON]
           ,[MODIFIED_BY]
           ,[MODIFIED_ON])
     VALUES
           ('Employee 1'
           ,25
           ,1000
           ,1
           ,1
           ,-1
           ,GETDATE()
           ,-1
           ,GETDATE())
GO



SELECT * FROM ADDRESS;
SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;