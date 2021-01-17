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

-- ROLE table data
INSERT INTO [dbo].[ROLE] ([ROLE_NAME]) VALUES ('USER')
INSERT INTO [dbo].[ROLE] ([ROLE_NAME]) VALUES ('ADMIN')


--USER DETAILS table data
INSERT INTO [dbo].[USER_DETAILS] ([USER_NAME],[PASSWORD],[ROLE_ID])
	VALUES ('user1@gmail.com','user1@123',1)

INSERT INTO [dbo].[USER_DETAILS] ([USER_NAME],[PASSWORD],[ROLE_ID])
	VALUES ('admin@gmail.com','$2y$12$hti1dfKsMnblS7EsSRHjPe/4GXcqWnzqerLNrmmiR2utPu5Lwahia',2)

--Role table data
INSERT INTO [dbo].[ROLE] ([ROLE_NAME]) VALUES ('User')
INSERT INTO [dbo].[ROLE] ([ROLE_NAME]) VALUES ('Admin')



SELECT * FROM ADDRESS;
SELECT * FROM DEPARTMENT;
SELECT * FROM EMPLOYEE;