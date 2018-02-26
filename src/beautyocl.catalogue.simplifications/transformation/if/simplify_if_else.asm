<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="simplify_if_else"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchremoveIf():V"/>
		<constant value="__exec__"/>
		<constant value="removeIf"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyremoveIf(NTransientLink;):V"/>
		<constant value="isTrue"/>
		<constant value="MOCL!BooleanExp;"/>
		<constant value="0"/>
		<constant value="booleanSymbol"/>
		<constant value="9:60-9:64"/>
		<constant value="9:60-9:78"/>
		<constant value="MOCL!OclExpression;"/>
		<constant value="10:60-10:65"/>
		<constant value="__matchremoveIf"/>
		<constant value="IfExp"/>
		<constant value="OCL"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="condition"/>
		<constant value="J.isTrue():J"/>
		<constant value="B.not():B"/>
		<constant value="32"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="o"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="a"/>
		<constant value="Replace"/>
		<constant value="ACT"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="14:3-14:4"/>
		<constant value="14:3-14:14"/>
		<constant value="14:3-14:23"/>
		<constant value="16:5-16:20"/>
		<constant value="__applyremoveIf"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="source"/>
		<constant value="thenExpression"/>
		<constant value="target"/>
		<constant value="18:3-18:4"/>
		<constant value="18:15-18:16"/>
		<constant value="18:3-18:17"/>
		<constant value="19:3-19:4"/>
		<constant value="19:15-19:16"/>
		<constant value="19:15-19:31"/>
		<constant value="19:3-19:32"/>
		<constant value="17:2-20:3"/>
		<constant value="link"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="41">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="42"/>
			<call arg="43"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="44"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="0" name="17" begin="0" end="9"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="46"/>
		<parameters>
		</parameters>
		<code>
			<load arg="47"/>
			<get arg="48"/>
		</code>
		<linenumbertable>
			<lne id="49" begin="0" end="0"/>
			<lne id="50" begin="0" end="1"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="45">
		<context type="51"/>
		<parameters>
		</parameters>
		<code>
			<pushf/>
		</code>
		<linenumbertable>
			<lne id="52" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="53">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="54"/>
			<push arg="55"/>
			<findme/>
			<push arg="56"/>
			<call arg="57"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="58"/>
			<call arg="59"/>
			<call arg="60"/>
			<if arg="61"/>
			<getasm/>
			<get arg="1"/>
			<push arg="62"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="42"/>
			<pcall arg="63"/>
			<dup/>
			<push arg="64"/>
			<load arg="19"/>
			<pcall arg="65"/>
			<dup/>
			<push arg="66"/>
			<push arg="67"/>
			<push arg="68"/>
			<new/>
			<pcall arg="69"/>
			<pusht/>
			<pcall arg="70"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="71" begin="7" end="7"/>
			<lne id="72" begin="7" end="8"/>
			<lne id="73" begin="7" end="9"/>
			<lne id="74" begin="24" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="64" begin="6" end="31"/>
			<lve slot="0" name="17" begin="0" end="32"/>
		</localvariabletable>
	</operation>
	<operation name="75">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="76"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="64"/>
			<call arg="77"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="66"/>
			<call arg="78"/>
			<store arg="79"/>
			<load arg="79"/>
			<pop/>
			<load arg="79"/>
			<load arg="29"/>
			<set arg="80"/>
			<load arg="79"/>
			<load arg="29"/>
			<get arg="81"/>
			<set arg="82"/>
		</code>
		<linenumbertable>
			<lne id="74" begin="8" end="9"/>
			<lne id="83" begin="10" end="10"/>
			<lne id="84" begin="11" end="11"/>
			<lne id="85" begin="10" end="12"/>
			<lne id="86" begin="13" end="13"/>
			<lne id="87" begin="14" end="14"/>
			<lne id="88" begin="14" end="15"/>
			<lne id="89" begin="13" end="16"/>
			<lne id="90" begin="10" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="66" begin="7" end="16"/>
			<lve slot="2" name="64" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="91" begin="0" end="16"/>
		</localvariabletable>
	</operation>
</asm>
