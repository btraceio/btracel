// Generated from /home/jbachorik/Desktop/BTraceL.g4 by ANTLR 4.1
package com.sun.btrace.btracel.model.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BTraceLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BTraceLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BTraceLParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull BTraceLParser.AssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull BTraceLParser.BlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp_mul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_mul(@NotNull BTraceLParser.Exp_mulContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(@NotNull BTraceLParser.TypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#handlers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlers(@NotNull BTraceLParser.HandlersContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp_unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_unary(@NotNull BTraceLParser.Exp_unaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#methodmatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodmatch(@NotNull BTraceLParser.MethodmatchContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#cutpoint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCutpoint(@NotNull BTraceLParser.CutpointContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp_binary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_binary(@NotNull BTraceLParser.Exp_binaryContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#pkgid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPkgid(@NotNull BTraceLParser.PkgidContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp_plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_plus(@NotNull BTraceLParser.Exp_plusContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#methodid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodid(@NotNull BTraceLParser.MethodidContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#cutdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCutdef(@NotNull BTraceLParser.CutdefContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#terminator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminator(@NotNull BTraceLParser.TerminatorContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#regex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegex(@NotNull BTraceLParser.RegexContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#subclasses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubclasses(@NotNull BTraceLParser.SubclassesContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#followdef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFollowdef(@NotNull BTraceLParser.FollowdefContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull BTraceLParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp_minus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_minus(@NotNull BTraceLParser.Exp_minusContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull BTraceLParser.ExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(@NotNull BTraceLParser.ArgumentsContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull BTraceLParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp_mod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_mod(@NotNull BTraceLParser.Exp_modContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#classmatch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassmatch(@NotNull BTraceLParser.ClassmatchContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#exp_div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_div(@NotNull BTraceLParser.Exp_divContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#functionEval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionEval(@NotNull BTraceLParser.FunctionEvalContext ctx);

	/**
	 * Visit a parse tree produced by {@link BTraceLParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler(@NotNull BTraceLParser.HandlerContext ctx);
}