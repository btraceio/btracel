// Generated from /home/jbachorik/src/java/btracel/src/BTraceL.g4 by ANTLR 4.1
package com.sun.btrace.btracel.model.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BTraceLParser}.
 */
public interface BTraceLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BTraceLParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(@NotNull BTraceLParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(@NotNull BTraceLParser.ArglistContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull BTraceLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull BTraceLParser.AssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_mul}.
	 * @param ctx the parse tree
	 */
	void enterExp_mul(@NotNull BTraceLParser.Exp_mulContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_mul}.
	 * @param ctx the parse tree
	 */
	void exitExp_mul(@NotNull BTraceLParser.Exp_mulContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull BTraceLParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull BTraceLParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_compare}.
	 * @param ctx the parse tree
	 */
	void enterExp_compare(@NotNull BTraceLParser.Exp_compareContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_compare}.
	 * @param ctx the parse tree
	 */
	void exitExp_compare(@NotNull BTraceLParser.Exp_compareContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull BTraceLParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull BTraceLParser.TypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#handlers}.
	 * @param ctx the parse tree
	 */
	void enterHandlers(@NotNull BTraceLParser.HandlersContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#handlers}.
	 * @param ctx the parse tree
	 */
	void exitHandlers(@NotNull BTraceLParser.HandlersContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_unary}.
	 * @param ctx the parse tree
	 */
	void enterExp_unary(@NotNull BTraceLParser.Exp_unaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_unary}.
	 * @param ctx the parse tree
	 */
	void exitExp_unary(@NotNull BTraceLParser.Exp_unaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull BTraceLParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull BTraceLParser.ArgContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#ifblock}.
	 * @param ctx the parse tree
	 */
	void enterIfblock(@NotNull BTraceLParser.IfblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#ifblock}.
	 * @param ctx the parse tree
	 */
	void exitIfblock(@NotNull BTraceLParser.IfblockContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#methodmatch}.
	 * @param ctx the parse tree
	 */
	void enterMethodmatch(@NotNull BTraceLParser.MethodmatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#methodmatch}.
	 * @param ctx the parse tree
	 */
	void exitMethodmatch(@NotNull BTraceLParser.MethodmatchContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#cutpoint}.
	 * @param ctx the parse tree
	 */
	void enterCutpoint(@NotNull BTraceLParser.CutpointContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#cutpoint}.
	 * @param ctx the parse tree
	 */
	void exitCutpoint(@NotNull BTraceLParser.CutpointContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_binary}.
	 * @param ctx the parse tree
	 */
	void enterExp_binary(@NotNull BTraceLParser.Exp_binaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_binary}.
	 * @param ctx the parse tree
	 */
	void exitExp_binary(@NotNull BTraceLParser.Exp_binaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#pkgid}.
	 * @param ctx the parse tree
	 */
	void enterPkgid(@NotNull BTraceLParser.PkgidContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#pkgid}.
	 * @param ctx the parse tree
	 */
	void exitPkgid(@NotNull BTraceLParser.PkgidContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_plus}.
	 * @param ctx the parse tree
	 */
	void enterExp_plus(@NotNull BTraceLParser.Exp_plusContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_plus}.
	 * @param ctx the parse tree
	 */
	void exitExp_plus(@NotNull BTraceLParser.Exp_plusContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(@NotNull BTraceLParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(@NotNull BTraceLParser.SignatureContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#methodid}.
	 * @param ctx the parse tree
	 */
	void enterMethodid(@NotNull BTraceLParser.MethodidContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#methodid}.
	 * @param ctx the parse tree
	 */
	void exitMethodid(@NotNull BTraceLParser.MethodidContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#cutdef}.
	 * @param ctx the parse tree
	 */
	void enterCutdef(@NotNull BTraceLParser.CutdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#cutdef}.
	 * @param ctx the parse tree
	 */
	void exitCutdef(@NotNull BTraceLParser.CutdefContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#terminator}.
	 * @param ctx the parse tree
	 */
	void enterTerminator(@NotNull BTraceLParser.TerminatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#terminator}.
	 * @param ctx the parse tree
	 */
	void exitTerminator(@NotNull BTraceLParser.TerminatorContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#regex}.
	 * @param ctx the parse tree
	 */
	void enterRegex(@NotNull BTraceLParser.RegexContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#regex}.
	 * @param ctx the parse tree
	 */
	void exitRegex(@NotNull BTraceLParser.RegexContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#elseblock}.
	 * @param ctx the parse tree
	 */
	void enterElseblock(@NotNull BTraceLParser.ElseblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#elseblock}.
	 * @param ctx the parse tree
	 */
	void exitElseblock(@NotNull BTraceLParser.ElseblockContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#subclasses}.
	 * @param ctx the parse tree
	 */
	void enterSubclasses(@NotNull BTraceLParser.SubclassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#subclasses}.
	 * @param ctx the parse tree
	 */
	void exitSubclasses(@NotNull BTraceLParser.SubclassesContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#followdef}.
	 * @param ctx the parse tree
	 */
	void enterFollowdef(@NotNull BTraceLParser.FollowdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#followdef}.
	 * @param ctx the parse tree
	 */
	void exitFollowdef(@NotNull BTraceLParser.FollowdefContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_minus}.
	 * @param ctx the parse tree
	 */
	void enterExp_minus(@NotNull BTraceLParser.Exp_minusContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_minus}.
	 * @param ctx the parse tree
	 */
	void exitExp_minus(@NotNull BTraceLParser.Exp_minusContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull BTraceLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull BTraceLParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull BTraceLParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull BTraceLParser.ExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(@NotNull BTraceLParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(@NotNull BTraceLParser.ArgumentsContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull BTraceLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull BTraceLParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_mod}.
	 * @param ctx the parse tree
	 */
	void enterExp_mod(@NotNull BTraceLParser.Exp_modContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_mod}.
	 * @param ctx the parse tree
	 */
	void exitExp_mod(@NotNull BTraceLParser.Exp_modContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#classmatch}.
	 * @param ctx the parse tree
	 */
	void enterClassmatch(@NotNull BTraceLParser.ClassmatchContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#classmatch}.
	 * @param ctx the parse tree
	 */
	void exitClassmatch(@NotNull BTraceLParser.ClassmatchContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#exp_div}.
	 * @param ctx the parse tree
	 */
	void enterExp_div(@NotNull BTraceLParser.Exp_divContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#exp_div}.
	 * @param ctx the parse tree
	 */
	void exitExp_div(@NotNull BTraceLParser.Exp_divContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#functionEval}.
	 * @param ctx the parse tree
	 */
	void enterFunctionEval(@NotNull BTraceLParser.FunctionEvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#functionEval}.
	 * @param ctx the parse tree
	 */
	void exitFunctionEval(@NotNull BTraceLParser.FunctionEvalContext ctx);

	/**
	 * Enter a parse tree produced by {@link BTraceLParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterHandler(@NotNull BTraceLParser.HandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link BTraceLParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitHandler(@NotNull BTraceLParser.HandlerContext ctx);
}