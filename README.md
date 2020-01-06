# About 

Spring Boot Utility App to fetch and list objects from IBM Cloud Storage Buckets(Public/Private)

# Features

A>This utility helps in fetching objects from any public and private buckets in IBM Cloud Storage. JPG/PNG/GIF objects can be viewed and downloaded. Other object types can be downloaded(One can customize them to view on browser).
  
B>This utility helps in listing down all objects(name and extension) that are in a public/private bucket.

# Benefits

1>This utility can be used by anyone to fetch and list the objects in their IBM Cloud Storage buckets. No customizations are needed.

2>This is an easy to use utility. To use it one can containerize it using docker or any other containerization platform and then deploy it on Kubernetes or any other Container Runtime.One can also try deploying it as a war(In that case it has to be checked if the application server can access IBM Cloud or not).

# Pre-Requisites

A> Generate IBM Cloud Access key and Secret key (Include HMAC while generating credentials)

B>To install/deploy on Openshift, all that was needed was an accessible Openshift Web Console and oc cli.

To create application war and then dockerize it, below is what is needed:

1>Spring Boot/Eclipse or any other IDE which supports Maven projects.- (To make any customizations if one wants or to run in local or create war from IDE)

2>Maven installed in local (To build a war)

3>Docker installed in local(If one wants to use the docker approach)- To create a container image and push the same in an image registry, which can later be used for deployment.

# Steps to Install/Deploy

A> On Openshift

This deployment was done on Openshift. Here are the steps:

1>Go to Openshift WebConsole

2>Click on 'Add to Project' and 'Browse Catalog'

3>Choose from Languages - Java and then choose Jboss EAP 7.2

![image](https://user-images.githubusercontent.com/50587555/71826785-c67c9c80-30c4-11ea-89ba-f0fb9d253b68.png)

4>Mention the app name of choice, git repo url, git reference(master if it is kept in your git master branch), context directory value as '.'
Other fields are kept as is.Click on Next. There one can bind secret or leave it(For this case it was not bound).

![image](https://user-images.githubusercontent.com/50587555/71826839-f166f080-30c4-11ea-8008-274eb33b37eb.png)

![image](https://user-images.githubusercontent.com/50587555/71826871-0774b100-30c5-11ea-8f19-74791bbd8a4c.png)

5>Click on Create

Alternatively the above 5 steps can be done through oc cli using the command mentioned below:

  oc new-app --template=eap72-basic-s2i 
 -p IMAGE_STREAM_NAMESPACE=eap 
 -p SOURCE_REPOSITORY_URL=https://github.com/ardlal1989/fetchibmclJSP.git
 -p SOURCE_REPOSITORY_REF=master
 -p CONTEXT_DIR=.
 
6>From oc cli, one can watch the status of objects such as pods

  oc login (using token)
  
  oc get pods -w -- To view the status of pods
  
  You can also use web console for the same
  
7>Create Route from web console to expose it for external access

![image](https://user-images.githubusercontent.com/50587555/71830504-e1eba580-30cc-11ea-94aa-80d78432e82b.png)

oc cli can also be used for the same

oc get svc ---> To get the service name

oc expose svc/<service name> ---> To expose it as Route
  
oc get route ---> To get the route url

Once it is deployed you can test it. Sample url is:

https://eap-app-containercrush-project4.inmbzp8022.in.dst.ibm.com/FetchFromIBMCloud-0.0.1-SNAPSHOT/getObjPvtInp  --- For fetch objects

https://eap-app-containercrush-project4.inmbzp8022.in.dst.ibm.com/FetchFromIBMCloud-0.0.1-SNAPSHOT/listObjectsInput  --- For listing objects in bucket  

B> On other container platform

If one does not use Openshift, and plans to deploy it as a container (Eg using docker) on some other container platform. Here are the steps:

1>Create a war, using maven(either from IDE or CLI)

2>Containerize using a docker file and push in a image registry. One can run the container on local container runtime or host the pushed image as a container on Kubernetes or any cloud platform.

# Time/ Efforts needed to install

On Openshift: 5-10 mins

Dockerize/Deploy And Use:1.5 hours

# Test Results

## Get Objects

Give the necessary input details

![image](https://user-images.githubusercontent.com/50587555/71829483-c5e70480-30ca-11ea-892b-881b9e25021c.png)

![image](https://user-images.githubusercontent.com/50587555/71827297-f4161580-30c5-11ea-8196-a4934cea79ed.png)

## List Objects

Give the necessary input details

![image](https://user-images.githubusercontent.com/50587555/71829573-f2028580-30ca-11ea-8e52-849939ee6e7f.png)

![image](https://user-images.githubusercontent.com/50587555/71827217-c630d100-30c5-11ea-9a9c-5b7fd6a6271c.png)


