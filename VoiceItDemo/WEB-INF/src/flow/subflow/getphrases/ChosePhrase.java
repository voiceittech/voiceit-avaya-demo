package flow.subflow.getphrases;

import java.security.SecureRandom;
import java.util.Random;

import com.avaya.sce.runtimecommon.ICollection;
import com.avaya.sce.runtimecommon.IComplexVariable;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.VariableName;

/**
 * A basic servlet which allows a user to define their code, generate
 * any output, and to select where to transition to next.
 * Last generated by Orchestration Designer at: 2018-NOV-07  08:03:07 PM
 */
public class ChosePhrase extends com.avaya.sce.runtime.BasicServlet {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2018-NOV-07  08:03:07 PM
	 */
	public ChosePhrase() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * This method allows for custom integration with other Java components.
	 * You may use Java for sophisticated logic or to integrate with custom
	 * connectors (i.e. JMS, custom web services, sockets, XML, JAXB, etc.)
	 *
	 * Any custom code added here should work as efficiently as possible to prevent delays.
	 * It's important to design your callflow so that the voice browser (Voice Portal/IR)
	 * is not waiting too long for a response as this can lead to a poor caller experience.
	 * Additionally, if the response to the client voice browser exceeds the configured
	 * timeout, the platform may throw an "error.badfetch". 
	 *
	 * Using this method, you have access to all session variables through the 
	 * SCESession object.
	 *
	 * The code generator will *** NOT *** overwrite this method in the future.
	 * Last generated by Orchestration Designer at: 2018-NOV-07  08:03:07 PM
	 */
	public void servletImplementation(com.avaya.sce.runtimecommon.SCESession mySession) {
		// randomly select a phrase from the list
		ICollection collection = mySession.getVariable(flow.IProjectVariables.ALL_PHRASES).getCollection();
		IComplexVariable variable = mySession.getVariable(flow.IProjectVariables.ALL_PHRASES).getComplexVariable();
		int randomIndex = ((Random)new SecureRandom()).nextInt(collection.size());
		collection.reset();
		for (int idx = 0; idx < randomIndex; idx++) {
			collection.next();
		}
		// store the value in the chosenPhrase variable.
		VariableName variableName = new VariableName(flow.IProjectVariables.PHRASE_INFO, flow.IProjectVariables.PHRASE_INFO_FIELD_PHRASE);
		mySession.getTraceOutput().writeln(ITraceInfo.TRACE_LEVEL_DEBUG, String.format("Storing [%s] to [%s]", variable.getField(flow.IProjectVariables.ALL_PHRASES_FIELD_TEXT).getStringValue(), variableName.toString()));
		mySession.getVariableField(variableName).setValue(variable.getField(flow.IProjectVariables.ALL_PHRASES_FIELD_TEXT).getStringValue());
	}
	/**
	 * Builds the list of branches that are defined for this servlet object.
	 * This list is built automatically by defining Goto nodes in the call flow editor.
	 * It is the programmer's responsibilty to provide at least one enabled Goto.<BR>
	 *
	 * The user should override updateBranches() to determine which Goto that the
	 * framework will activate.  If there is not at least one enabled Goto item, 
	 * the framework will throw a runtime exception.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.  To modify the list
	 * of branches for the flow item, override:
	 *     <code>updateBranches(Collection branches, SCESession mySession)</code>
	 *
	 * @return a Collection of <code>com.avaya.sce.runtime.Goto</code>
	 * objects that will be evaluated at runtime.  If there are no gotos
	 * defined in the Servlet node, then this returns null.
	 * Last generated by Orchestration Designer at: 2018-NOV-12  08:02:55 AM
	 */
	public java.util.Collection getBranches(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Goto aGoto = null;
		list = new java.util.ArrayList(1);

		aGoto = new com.avaya.sce.runtime.Goto("getphrases-Default", 0, true, "Default");
		list.add(aGoto);

		return list;
	}
}
