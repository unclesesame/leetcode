Presentation

1. Hello everyone, I'm here today to talk to you about our project  FRTB SA CVA. The agenda will be first I will give you some introduction about our architecture and design, later I'd like to demo with you our project in CRMR WS and tableau.

This diagram shows you the oveall architecutre on how our project works, 
Let's start from the top, we introduced autosys as it's daily batch job, we have two views in CRMR WS, one is sensitivity analysis, the other one is FRTB SA CVA. From the two views user can review the data and signoff. If they have interests or doules on the numbers, they can click the links on the numbers, it will redirect to Tableau for further analysis.  

From the left hand side, you can see we have a few upstream and downstream systems....


Let's move on to Data loading, we decoupled data loading from our batch run, so that there is no any interactions with other systems. All the dependencies from upstream systems have been taken care in data loading.

The major tasks in data loading are feed conversion and validation check, and we send the UIN_ID and nettingset names with DQ issues to Optima BA CVA team for further treatment. 

Input data and data with DQ issues is stored down in Hive,  and there is a separte process to have data syncing from Hive to Oracle. Data in Orale will be used for frontend and Tableau.

Once all feeds are ready in Hive, we can start our batch, first we fetch the input data from Hive, get some predefined configurations and metadata from Oracle. Here is the major 5 steps in batch run. 1)Filter here I used broken line means it is only applicable if it's ad-hoc request from user, for example user may only want to see the result of one sepecific Netting set, then we will firstly do filtering to narrow down the population  The rest steps are enrichment ，job spliting, aggregation and calculation, for more details let me move on to next slide.

After filtering if necessary, the next step is enrichment, in this step, CVA and hedge data is joined with business hierarchy, so we are able to know the business node at level 1, 4, 6 and 12. In CVA, we have UIN_ID, these five levels are required by user which we should report at.

I would like to elaborate further regarding to job splitting, unlike Accouting CVA and other risk values, the formular of FRTB SA CVA is quite different, we are not able to first calculate at low level and aggregate to high level. So we have to calculate for each level and each options in this level separately. From latest CVA feed from XRS, for one fs type, we have more than one thousand options, here we use a thread pool to manage each calculation job and run them in parallel.  Here list some samples, thread 1 is for Level 1, and level 1 there is only one option which is CITI_GROUP_MTM, and thread 2 for  OTHER_CITI_MTKS at LEVEL4, so on and so force, we have more than 1 thousand threads,  and each of the thread is actually a spark job, based on yarn scheduler, jobs will be assigned to mutiple executors.  Aggregation and calculation get completed on each executor, once we get the final result after calculation, we will not send the result back to Driver, instead we store down the result directly in Hive to save time. All above I mentioned is within one spark application for one fs type, we can have totally 11 spark applications running for 11 fs types. In this design, fs types are splitted into differnt spark applications, resources are segregated among spark applications. So we have parallelism at 3 levels 
1)for different fs types, we can run in parallel based on different spark applications
2)in one specific fs type, different options in each business level are running in parallel using thread pool
3)in one specific executor, tasks for different partitions are running in parallel,which is benefit from the mechanism ˈmekənɪzəm of spark .

well that.s about the architecture and design
let us move on to CRMR WS


CRMR WS:
There is some issues running CRMR WS on my local, today I will check again with Swati once she is available, so now let's assume it's working good.
Now we are in the signoff screen of CRMR WS, in this screen, we have two views, one is Sensitivity Analysis which we are showing the cva and hedge sensitivities, in this toggle, we also have comparsion between B25 and SA CVA, the other view is FRTB SA CVA, this one we only finished the code structure, still we are in development. once we click the SA CVA toggle tɒɡl, we can see the cva and hedge values by fs type, if we unfold this, we can drill down to lower level. when we click this number for  COMMOD_CVA at level 6, we can redirect to Tableau for further analysis.

Ok, now we are in Tableau, as you can see in this workbook, data is fitered, we can only see COMMOD_CVA at level 6.

this is the CRMR WS  tableau integration .

Tableau:
I would like to introduce more about our dashboard in Tableau.
This is the Tableau dashboard for Risk charge Analysis. On the top,you can select currect cob date and prior cob date.  right after that is the total amounts and delta amounts comparing to prior cob date.

1) Here we have a line chart represents the risk charge trend over date, 
2)This is a historgram, each color represents a different fs type, also you can find the persentage for one specific fs type,  here actually we have four available fs types, you can only clearly see two dur to the persentage for CMVG and FXVG  is too small. If you click CMDL, all numbers and charts in the dashboard got refreshed,only showing the CMDL values. 

In the bottom left, this is a Pie chart, This graph gives you a break down  by bucket, you also can see the percentage for each bucket. In the right  here is a table, let me unselect CMDL first,

in this table, you can select one specific level, and then you will see the values cross different fs types.

well pretty much for the presentation  any questions and suggestions ?

horizontal axis  vertical Axis

Take a look at this…　

…　　


Well， that‘s about it for now， We’ve covered…


it's only the mechanism ˈmekənɪzəm in spark . It's not a CPU intensive job, once calcalation completed, when writing data to Hive
