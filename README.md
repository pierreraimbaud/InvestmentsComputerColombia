<h2>Investments (in Colombian pesos) for education, on computers, in each department and city.</h2>
<h2>Author</h2>
Pierre Raimbaud : https://github.com/pierreraimbaud, GitHub project link : https://github.com/pierreraimbaud/InvestmentsComputerColombia and Projet page : https://pierreraimbaud.github.io/InvestmentsComputerColombia/<br/><br/>
This project is under MIT license (applied to the repository).<br/><br/>
<img src="/TreeMapInvestComputColombia.png" alt="TreeMapInvestComputColombia"><br/>
<p style="color:#111111;">
This visualization uses data from datos.gov.co The principal objective here is to show or discover some interesting insights about this data, knowing that the principal question here is:<br/><b>Could I know, the global distribution of the investments ? Could I know where the investments where the highest and the lowest?</b>
                <br/><br/>
                The other objetives are more academic: to use d3, to publish the web page on GithubPages etc. The technologies used are d3 (javascript), HTML, CSS and git (nodejs for developing with a local server). There is no specific prerequisites for enjoying the visualization neither for using the code, available in github.
                <br/><br/>
                To be more precise, in the following paragraphs first we will explain what were our data (through data abstraction), why this visualization (through task abstraction) and to conclude the reason of how we choice to present the data (idioms : visual encoding and interaction) ; thanks to that, we have been able to answer to the title question : <i>Investments on computers and tablets on whole Colombia, but with which distribution ? Where the investments have been the highest and the lowest ?</i>, which answers are our insights !
<br/>
</p>
            <h2>What, why and how ? Understanding this visualization thanks to abstraction</h2>
              <p style="color:#789410;font-size:110%">What ?</p>
              <p style="color:#111111;">
                Let's precise first that here one derived dataset is used at the end in the visualization. It has been created from the original dataset thanks to a custom Java program (available in the repository). The final dataset type is <b>tree</b> (initially, it was a <b>table</b> - originally, almost all the dataset are tables, but, after processing the data for creating new datasets (and new files) we obtained two network datasets. For this case, the dataset was a good cantidate for network dataset because it contains both categorical and quantitative data, where the categorical attributes have hierarchy (departments and cities) and the quantitative attributes "follow" this hierarchy, meaning that the sum of the quantitative attribute for cities of a department is the value of the quantitative attribute for this department.</br>The dataset availability is <b>static</b> because the dataset available on the website is not modified in real-time, so we just download the file from the website and load it on github. So for this case, we had to process the data, so we have done a <b>derivation task</b> to get <b>the derived data</b>.<br/><br/>
                Before processing the data, the <b>items</b> represent, each one, one investment, which has the following characteristics: id, period, city, department, value of the investment (there were other data but we decide to quit them because there were not revelant for our visualization). These characteristics are the <b>attributes</b>. Note that in Excel/Libre Office we first group and sum the investments by city, allowing the fusion of the values for a same city on different periods. So we will no longer talk about period afterwards.<br/><br/>
                The <b>attributes</b> id, city, department are categorical. The <b>attribute</b> value is ordered, quantitative and sequential.<br/><br/>
                After processing the data, we could say that we obtain <b>more or less the same items</b> : each item is still an investment but it represent the sum of investments for a deparment or a city. About the attributes, the id is the key value of each item. Each item has other attributes : name (still categorical, representing the city or the department), department (even repeated if the name was the department) which is still categorical and an attribute value which is ordered, quantitative and sequential - it represents the sum of the investments in the city or the department and the last attribute is children which allow to represent the hierarchy between item: the "department items" have as children the cities of the department and the "city items" have no children (empty). We can't forget the root item : Colombia! (the country, which contains all the deparments).<br/><br/>
            </p>
            <p style="color:#789410;font-size:110%">Why ?</p>
            <p style="color:#111111;">
              Before talking about the wanted tasks, we have to mention that we did derivation tasks (as explained before that). We processed the data and obtained a new file where data are a tree, with this structure: <i>{"name": "Colombia", "children": [{"name": "AMAZONAS", "value": 0,"children": [{"name": "LA CHORRERA", "value": 156217422.2}, ....], {"name": "VALLE DEL CAUCA",....</i>. These derivation tasks, in terms of Tamara were <b>Derive (action) Feature (target) on the items with all their attributes (derivation for getting new items and derivation for getting hierarchy).</b>.<br/><br/>
              Which tasks do we want to be able to perform here?<br/><br/>
              As said in the title, first, the primary task we want to perform here is <b>to show the global distribution of the investments on computers in Colombia.</b>
              In terms of Tamara, the action is <b>Summarize</b> and the target is <b>Distribution</b>.
              <br/><br/>
              But, also as said in the title, another primary task would be <b>to know where the investments have been the highest or the lowest ones.</b> In terms of Tamara, the task here is to <b>Identify</b> <b>Extremes</b>.
              So thanks to these tasks we have been able to get some <b>insights</b>. The first one is that, seeing the global distribution, we can observe that <b>the first 11 departments or divisions (under 33 in this dataset) represent more than the half of the investments in the whole country.</b> It is easy to see it looking horizontally until the half of the graph. The second one is that,<b>Antioquia and Valle del Cauca are the departments where the investments have been the highest whereas that Guainía and Vaupes are the departments where the investments have been the lowest.</b>.<br/><br/>
              One secondary task could be to see with more details each department, seeing the investments in each city. In terms of Tamara, at a low-level the action is <b>Explore</b> and the target is <b>Distribution</b> (the one inside a department). We can perform this task by clicking on a department and seeing the value for each city. As a result, for this task, <b>one insight is that in Nariño the highest investment has not been in Pasto but in San Andres de Tumaco, whereas Pasto is the capital.</b> If we look to other departments, it is more typical that in the capital of the departments the investments have been the highest one of the department.
              <br/><br/>
            </p>
            <p style="color:#789410;font-size:110%">How ?</p>
            <p style="color:#111111;">
              We choose <b>tree</b> for this visualization.<br/><br/>
              First, we have to say that there is no visual axis here.<br/><br/>
              About the visual encoding, the <b>mark</b> we choose is <b>area (rectangular shapes)</b> for the items (both "department" and "city" items - there would be no difference here about this HOW part for the two kinds of items). About the <b>channel</b> for the items, it is <b>area (2D size)</b>; it can be easily explain because it is a channel which are in the most <b>effective</b> for the ordered attributes (here the area represents the value of the investments).</br></br>
              We choose to <b>separate and order</b> the items as the idea was to be able to identify the highest and the lowest investments and also to see the global distribution. It combines well with our ordered attribute (value of investment) and with these principal tasks.
              <br/><br/>
              Then about the interactions, first we decide to provide to the user one interaction clicking on the department. It allows him to see the detail for one department: it is a kind of <b>Embed</b> because it "opens" the detailed view. To conclude, note that we also provide an interaction for going back to the global distribution view (clicking on the banner).
            </p>     
