// Generated from /Users/phil/NetBeansProjects/ruse0/ruse0.g4 by ANTLR 4.2.2

package ruse0;
import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ruse0Parser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, INT=2, NEWLINE=3, TIMES=4, DIVIDE=5, PLUS=6, MINUS=7, LPAREN=8, 
		RPAREN=9, CAR=10, CDR=11, CONS=12;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "INT", "NEWLINE", "'*'", "'/'", "'+'", "'-'", "'('", 
		"')'", "'car'", "'cdr'", "'cons'"
	};
	public static final int
		RULE_eval = 0, RULE_expr = 1, RULE_sequence = 2;
	public static final String[] ruleNames = {
		"eval", "expr", "sequence"
	};

	@Override
	public String getGrammarFileName() { return "ruse0.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ruse0Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode NEWLINE() { return getToken(ruse0Parser.NEWLINE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ruse0Listener ) ((ruse0Listener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ruse0Listener ) ((ruse0Listener)listener).exitEval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruse0Visitor ) return ((ruse0Visitor<? extends T>)visitor).visitEval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			setState(11);
			switch (_input.LA(1)) {
			case INT:
			case MINUS:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(6); ((EvalContext)_localctx).expr = expr();
				setState(7); match(NEWLINE);
				System.out.println(((EvalContext)_localctx).expr.v);
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 2);
				{
				setState(10); match(NEWLINE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Integer v;
		public ExprContext e1;
		public ExprContext e2;
		public Token INT;
		public TerminalNode INT() { return getToken(ruse0Parser.INT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public TerminalNode MINUS() { return getToken(ruse0Parser.MINUS, 0); }
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ruse0Parser.RPAREN, 0); }
		public TerminalNode PLUS() { return getToken(ruse0Parser.PLUS, 0); }
		public TerminalNode LPAREN() { return getToken(ruse0Parser.LPAREN, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ruse0Listener ) ((ruse0Listener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ruse0Listener ) ((ruse0Listener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruse0Visitor ) return ((ruse0Visitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(13); match(LPAREN);
				setState(14); match(PLUS);
				setState(15); ((ExprContext)_localctx).e1 = expr();
				setState(16); ((ExprContext)_localctx).e2 = expr();
				setState(17); match(RPAREN);
				 ((ExprContext)_localctx).v =  ((ExprContext)_localctx).e1.v + ((ExprContext)_localctx).e2.v; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20); match(LPAREN);
				setState(21); match(MINUS);
				setState(22); ((ExprContext)_localctx).e1 = expr();
				setState(23); ((ExprContext)_localctx).e2 = expr();
				setState(24); match(RPAREN);
				 ((ExprContext)_localctx).v =  0; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(27); ((ExprContext)_localctx).INT = match(INT);
				((ExprContext)_localctx).v =  new Integer((((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0));
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(29); match(MINUS);
				setState(30); ((ExprContext)_localctx).INT = match(INT);
				((ExprContext)_localctx).v =  0 - new Integer((((ExprContext)_localctx).INT!=null?Integer.valueOf(((ExprContext)_localctx).INT.getText()):0));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceContext extends ParserRuleContext {
		public ArrayList<Integer> vals;
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ruse0Listener ) ((ruse0Listener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ruse0Listener ) ((ruse0Listener)listener).exitSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ruse0Visitor ) return ((ruse0Visitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sequence);

		    // Add Java code here to create an ArrayList

		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16\'\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\3\2\3\2\5\2\16\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\4\3\4\3"+
		"\4\2\2\5\2\4\6\2\2\'\2\r\3\2\2\2\4\"\3\2\2\2\6$\3\2\2\2\b\t\5\4\3\2\t"+
		"\n\7\5\2\2\n\13\b\2\1\2\13\16\3\2\2\2\f\16\7\5\2\2\r\b\3\2\2\2\r\f\3\2"+
		"\2\2\16\3\3\2\2\2\17\20\7\n\2\2\20\21\7\b\2\2\21\22\5\4\3\2\22\23\5\4"+
		"\3\2\23\24\7\13\2\2\24\25\b\3\1\2\25#\3\2\2\2\26\27\7\n\2\2\27\30\7\t"+
		"\2\2\30\31\5\4\3\2\31\32\5\4\3\2\32\33\7\13\2\2\33\34\b\3\1\2\34#\3\2"+
		"\2\2\35\36\7\4\2\2\36#\b\3\1\2\37 \7\t\2\2 !\7\4\2\2!#\b\3\1\2\"\17\3"+
		"\2\2\2\"\26\3\2\2\2\"\35\3\2\2\2\"\37\3\2\2\2#\5\3\2\2\2$%\3\2\2\2%\7"+
		"\3\2\2\2\4\r\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}