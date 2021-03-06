/**
 * Last generated by Orchestration Designer at: (timestamp generation disabled)
 */
package english.prompts;

public class CreateEnrollInformRemaining extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for CreateEnrollInformRemaining.
	 */
	public CreateEnrollInformRemaining() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("CreateEnrollInformRemaining");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,8000);
		setBargin(1,true);

		if ( new com.avaya.sce.runtime.Condition( "condition", "enrollmentsRemaining", com.avaya.sce.runtime.Expression.INT_LESS_THAN, "THRESHOLD_ENROLL", true, null ).evaluate(getSession()) == true ) {
			if ( new com.avaya.sce.runtime.Condition( "condition", "enrollmentsRemaining", com.avaya.sce.runtime.Expression.INT_EQUAL, "1", false, null ).evaluate(getSession()) == true ) {
				add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"createenrollment:createenroll-1001",false));
			}
			else if ( new com.avaya.sce.runtime.Condition( "condition", "enrollmentsRemaining", com.avaya.sce.runtime.Expression.INT_EQUAL, "2", false, null ).evaluate(getSession()) == true ) {
				add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"createenrollment:createenroll-1002",false));
			}
			else {
				add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"createenrollment:createenroll-1003",false));
			}
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.PHRASESET,"createenrollment:createenroll-0006",false));
		}

		format = new com.avaya.sce.runtime.Format();
		format.add("time","250ms");
		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.XML_TAG_FULL,"break", format));

	}
}
