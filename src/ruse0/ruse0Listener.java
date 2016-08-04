// Generated from /Users/phil/NetBeansProjects/ruse0/ruse0.g4 by ANTLR 4.2.2

package ruse0;
import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ruse0Parser}.
 */
public interface ruse0Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ruse0Parser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(@NotNull ruse0Parser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ruse0Parser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(@NotNull ruse0Parser.SequenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ruse0Parser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(@NotNull ruse0Parser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ruse0Parser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(@NotNull ruse0Parser.EvalContext ctx);

	/**
	 * Enter a parse tree produced by {@link ruse0Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull ruse0Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ruse0Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull ruse0Parser.ExprContext ctx);
}