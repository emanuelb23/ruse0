// Generated from /Users/phil/NetBeansProjects/ruse0/ruse0.g4 by ANTLR 4.2.2

package ruse0;
import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ruse0Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ruse0Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ruse0Parser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(@NotNull ruse0Parser.SequenceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ruse0Parser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(@NotNull ruse0Parser.EvalContext ctx);

	/**
	 * Visit a parse tree produced by {@link ruse0Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(@NotNull ruse0Parser.ExprContext ctx);
}