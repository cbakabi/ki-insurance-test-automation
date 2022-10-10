# Ki Insurance Mock Platform Automation

Code:
- To implement reusable classes use the class `ELementsUtils.java` is available with reusable methods, corresponding stepdefs found at the bottom of the Mystepefs class.
- First scenario is expected to fail for 2 reasons: 1. Due to the date picker step not working as expected, 2. Due to the created quotes not appearing on the Pending Quotes as expected. The first issue would require collaboration with a dev and the second issue would require a bug to be raised. 

To run the tests:
- Press the play button on the left-hand side dock.
- Press the play button next to the scenario you want to run, to run just that scenario.
- Press the play button at the feature level to run all the tests and examples in the feature.

Pre-requistes:
- Make sure you have the cucumber and gherkin plugins enabled in your IDE.
- Check your Chrome version and install a chrome driver that corresponds to it. 
- The chrome driver attached to this project is for Chrome version 106 and above. Your Chrome version can be found in the settings and About Chrome section.
