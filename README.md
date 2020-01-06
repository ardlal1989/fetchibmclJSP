# About 

Spring Boot Utility App to fetch and list objects from IBM Cloud Storage Buckets(Public/Private)

# Features

A>This utility helps in fetching objects from any public and private buckets in IBM Cloud Storage. JPG/PNG/GIF objects can be viewed and downloaded. Other object types can
  be downloaded(You can customize them to view on browser).
  
B>This utility helps in listing down all objects(name and extension) that are in a public/private bucket.

# Benefits

1>This utility can be used by anyone to fetch and list the objects in their IBM Cloud Storage buckets. No customizations are needed.

2>This is an easy to use utility. To use it you can containerize it using docker or any other containerization platform and then deploy it on Kubernetes or any other Container Runtime.You can also try deploying it as a war(In that case you have to check if your application server can access IBM Cloud or not).

# Pre-Requisites needed to install

I installed/deployed it on Openshift. So all that was needed was an accessible Openshift Web Console and oc cli.

If you want to create application war and then dockerize it, you need the below:

1>Spring Boot/Eclipse or any other IDE which supports Maven projects.- (To make any customizations if you want or to run in local or create war from IDE)

2>Maven installed in local (To build a war)

3>Docker installed in local(If you want to use the docker approach)- To create a container image and push the same in an image registry, which can later be used for deployment.

# Steps to Install

I deployed it on Openshift. Here are the steps:

1>Go to Openshift WebConsole

2>Click on 'Add to Project' and 'Browse Catalog'

3>Choose from Languages - Java and then choose Jboss EAP 7.2

![image](https://user-images.githubusercontent.com/50587555/71826785-c67c9c80-30c4-11ea-89ba-f0fb9d253b68.png)

4>Mention the app name of your choice, git repo url, git reference(master if it is kept in your git master branch), context directory value as '.'
You can leave other fields as is, and click on Next. There you can bind secret or leave it(I did not bind).

![image](https://user-images.githubusercontent.com/50587555/71826839-f166f080-30c4-11ea-8008-274eb33b37eb.png)

![image](https://user-images.githubusercontent.com/50587555/71826871-0774b100-30c5-11ea-8f19-74791bbd8a4c.png)

5>Click on Create

6>From oc cli, you can watch the status of your objects such as pods
  oc get pods -w
  You can also use web console for the same

Once it is deployed you can test it. Sample url is:

https://eap-app-containercrush-project4.inmbzp8022.in.dst.ibm.com/FetchFromIBMCloud-0.0.1-SNAPSHOT/getObjPvtInp  --- For fetch objects
https://eap-app-containercrush-project4.inmbzp8022.in.dst.ibm.com/FetchFromIBMCloud-0.0.1-SNAPSHOT/listObjectsInput  --- For list objects in bucket  

If you are not using Openshift, but plan to deploy it as a container (Eg using docker). Here are the steps:

1>Create a war, using maven(either from IDE or CLI)

2>Containerize using a docker file and push in a image registry. You can run the container on local container runtime or host the pushed image as a container on Kubernetes or any cloud platform.

# Time/ Efforts needed to install

2 hours

# Test Results

## Get Objects

Give the necessary input details

![image](https://user-images.githubusercontent.com/50587555/71827120-8d90f780-30c5-11ea-8ae9-d9f7030e65d6.png)

![image](https://user-images.githubusercontent.com/50587555/71827297-f4161580-30c5-11ea-8196-a4934cea79ed.png)

## List Objects

Give the necessary input details

![image](https://user-images.githubusercontent.com/50587555/71827162-a9949900-30c5-11ea-9952-c6c4cf6b7f89.png)



![image](https://user-images.githubusercontent.com/50587555/71827217-c630d100-30c5-11ea-9a9c-5b7fd6a6271c.png)


